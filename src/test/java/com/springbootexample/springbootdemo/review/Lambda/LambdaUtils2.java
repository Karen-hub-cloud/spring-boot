package com.springbootexample.springbootdemo.review.Lambda;

public class LambdaUtils2 {
    static class Love2 implements iLove{

        @Override
        public void love(int a) {
            System.out.println("I LOVE YOU:"+a);
        }
    }
    public static void main(String[] args) {
        iLove love =  new Love();
        love.love(2);

         love = new Love2();
         love.love(3);

         class Love3 implements iLove{

            @Override
            public void love(int a) {
                System.out.println("I LOVE YOU:"+a);
            }
        }
        love = new Love3();
         love.love(4);

         iLove l = (int a)->{
             System.out.println("I LOVE YOU:"+a);
         };
         l.love(32);
         //简化
        //总结：表达式只能有一行代码的情况下，才能简化成为一行，否则必须加{}
        //前提：必须是函数式接口
        //多个参数也可以去掉参数类型，要去掉就都去掉,必须加上括号
        //
         iLove ll = a-> System.out.println("I LOVE YOU:"+a);
         ll.love(521);
    }

}
interface iLove{
    void love(int a);
}
class Love implements iLove{

    @Override
    public void love(int a) {
        System.out.println("I LOVE YOU:"+a);
    }
}
