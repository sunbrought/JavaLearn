package com.company.JavaClass;

public class HeroPlus {
    public String name;
    public float hp;
    public int damage;
    public int id;

    public static void main(String[] args) {
        System.out.println("执行main方法");
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
        System.out.println("调用了setName()方法");
    }
    public HeroPlus(){

    }
    public HeroPlus(String string) {
        name =string;
    }

    @Override
    public String toString() {
        return "Hero [name=" + name + "]";
    }
    public boolean isDead() {
        // TODO Auto-generated method stub
        return false;
    }
    public void attackHero(HeroPlus h2) {
        System.out.println(this.name+ " 正在攻击 " + h2.getName());
    }
}
