package com.springbootexample.springbootdemo.service;

import com.springbootexample.springbootdemo.entities.Em;
import com.springbootexample.springbootdemo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@Service
//这里使用@CacheConfig(cacheNames="emp")，下面的value可以去掉，比较方便，抽取缓存的公共配置
//@CacheConfig(cacheNames="emp")
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    /*
    @cacheable
    将方法的运行结果进行性缓存，以后要相同的数据，直接从缓存中获取，不用调用方法
    CacheMangr:管理多个Cache组件，对缓存的真正CRUD操作在Cache组件里，每一个缓存组件有自己唯一的名字
    几个属性：
        cacheName/valuse:缓存的名字;将方法的缓存结果放在哪个缓存中，是数组的方式，可以指定多个缓存；

        key:缓存数据使用的key,可以用它来指定，默认是使用方法参数的值
            1.方法的返回值
            编写SQEL表达式
        keyGenerator:key的生成器，可以自己指定key的生成器的组件id
            key/keyGenerator二选一
        cacheManger:指定缓存管理器，或者cacheResolver指定获取解析器
        condition:指定符合条件的情况下才缓存
        unless:否定缓存，当unless指定的条件未true,方法的返回值就不会被缓存，可以获取到结果进行判断
            unless:"#result == null"
        sync:是否使用异步模式

     */
    /*

    缓存的工作原理及步骤
    原理：
        1.自动配置类：CacheAutoConfiguration
        2.缓存的配置类
        3.哪个配置类默认生效？
        4/给容器中注册了一个CacheManger,ConcurrentMapCacheManager
        5.可以获取和创建ConcurrentMapCache类型的缓存组件，它的作用是将数据保存在ConcurrentMap中
    运行流程：
        @Cachable:
        1.方法运行之前，先去查询Cache(缓存组件)，按照cacheName指定的名字获取
            CacheManger先获取相应的缓存，第一次获取缓存，如果没有cache组件会自动创建出来
        2. 去cache中查找缓存的内容，使用一个key,默认就是方法的参数
            key是按照某种策略生成的：默认是使用keyGenerator,默认使用SimpleKeyGenerator
                SimpleKeyGenerator：
                    如果没有参数，就new一个SimpleKeyGenerator的对象，
                    如果有一个参数，key=参数值
                    如果有多个参数，key=new SimpleKey(params)
        3.没有查到缓存，就调用目标方法，将目标方法放到缓存中

        @Cachable：执行的方法执行之前先来检查缓存中有没有这个数据，默认按照参数的值作为key去查询缓存，
        如果没有就运行方法并将结果放到缓存里,以后再来调用就可以使用缓存里的数据。

        核心：
            1.使用CacheManager【ConcurrentMapCacheManager】按照名字得到Cache【ConcurrentMapCache】组件
            2.key使用KeyGenerator生成，默认是SimpleKeyGenerator

     */
//    @Cacheable(cacheNames = {"emp"},key = "#root.methodName+'['+#id+']'")
    @Cacheable(cacheNames = {"emp"})
    public Em getEmp(Integer id){
        //注意：走了缓存，这里的方法不会进来，这句话不会被打印
        System.out.println("检测方法是不是进来了");
        return employeeMapper.getEmployeeById(id);
    }
    /*
    @CachePut:即调用方法，又更新缓存数据
    修改了数据库的某个数据，同时更新缓存
    运行先调用目标方法，将返回结果缓存起来
     */
    /*
    调用这个方法，再查询数据，发现没有更新缓存，为什么？
    getEmp这个方法，在缓存里存的值，key是id
    updateEmp这个方法，在缓存里存的值，key是employee对象
    所以在缓存中更新没有成功，key不同
     */
//    @CachePut(value = "emp")
    /*
    解决
    key = "#employee.id":使用传入参数的员工id
    key = "#result.id":使用返回后的id
    note:@cacheable的key是不能用"#result.id"的
     */
    @CachePut(value = "emp", key = "#employee.id")
    public Em updateEmp(Em employee){
         employeeMapper.updateEmployee(employee);
         return employee;
    }
    /*
    @CacheEvict：清楚缓存
    通过key指定emp中要删除的值
    如果没有指定key,则使用传参作为key

    allEntries = true：将emp中所有的key-value全清掉
    beforeInvocation = false:缓存的清除是否在方法之前执行
    默认代表是在方法执行之后执行：删除出错了，缓存不会被清空
     */
    @CacheEvict(value = "emp",key = "#id")
    public void deleteEmp(Integer id){
        System.out.println("删除员工："+id);
        employeeMapper.deleteEmp(id);
    }
    /*
    可指定多个缓存规则
     */
    @Caching(
        cacheable = {
                @Cacheable(value = "emp",key = "#lastName")
        },
         put = {
                @CachePut(value = "emp",key = "#result.id"),
                @CachePut(value = "emp",key = "#result.email")
         }
    )
    public Em getEm(String lastName){
        return employeeMapper.getEmByLastName(lastName);
    }

}
