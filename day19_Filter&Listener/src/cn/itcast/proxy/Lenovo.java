package cn.itcast.proxy;

/**
 * @author JacksonTom
 * @date 2021-01-15
 * @function
 */
//真实类
public class Lenovo implements SellComputer {
    @Override
    public String sell(double money) {
        System.out.println("花了" + money + "元");
        return "联想电脑";
    }

    public void show(){
        System.out.println("展示电脑");
    }
}
