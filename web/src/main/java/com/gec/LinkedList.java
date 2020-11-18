package com.gec;

import org.junit.Test;

/**
 * @author Brice
 * @title: LinkedList
 * @projectName mainDemo
 * @description: TODO
 * @date 2020/11/2016:54
 */
public class LinkedList {
    public static void main(String[] args) {
        HeroNode h1 = new HeroNode(1,"1","1");
        HeroNode h2 = new HeroNode(2,"2","2");
        HeroNode h3 = new HeroNode(3,"3","3");
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add(h1);
        linkedList.add(h3);
        linkedList.add(h2);
        linkedList.iter();
        System.out.println("-------------------------------1");
        linkedList.update(new HeroNode(2, "3", "3"));
        linkedList.iter();
        System.out.println("-------------------------------2");
        linkedList.del(1);
        linkedList.del(3);
        linkedList.del(3);
        linkedList.del(2);
        linkedList.iter();
        System.out.println("-------------------------------1");
    }


}

class SingleLinkedList{
    //头节点
    private HeroNode head = new HeroNode(0,"","");
    //添加
    public void add(HeroNode newHero){
        //头不可改变,用临时对象temp进行操作
        HeroNode temp = head;
        boolean flag = false;//添加的node是否存在
        while(true){
            if(temp.getNext()==null){
                break;//判断是否到链表最后了
            }
            if(temp.getNext().getNo()>newHero.getNo()){
                //进行排序
                break;
            }else if(temp.getNext().getNo()==newHero.getNo()){
                //已经存在
                flag=true;
                break;
            }
            temp=temp.getNext();
        }
        newHero.setNext(temp.getNext());
        temp.setNext(newHero);
    }
    //修改
    public void update(HeroNode newHero){
        //判断链表是否为空
        if(head.getNext()==null){
            System.out.println("链表为空");
            return;
        }
        //头链表不能动
        HeroNode temp = head;
        boolean flag=false;//标记是否有这个对象
        while(true){
            if(temp.getNext()==null){
                break;//判断是否到链表末尾
            }
            if(temp.getNext().getNo()==newHero.getNo()){
                flag=true;//判断是否存在该对象
                break;
            }
            temp=temp.getNext();//迭代
        }
        if(flag){
            temp.getNext().setName(newHero.getName());
            temp.setNickname(newHero.getNickname());
        }else{
            System.out.println("该链表没有存储该对象");
        }
    }
    //删除
    public void del(Integer no){
        //不能动头
        HeroNode temp = head;
        boolean flag=false;//是否找到要删除节点
        while(true){
            if(temp.getNext()==null){
                break;//判断是否到链表末尾
            }
            if(temp.getNext().getNo()==no){
                flag=true;//找到节点
                break;
            }
            temp=temp.getNext();//迭代
        }
        if(flag){
           temp.setNext(temp.getNext().getNext());
        }else{
            System.out.println("要删除的对象不存在");
        }



    }

    //迭代遍历
    public void iter(){
        //判断链表是否为空
        if(head.getNext()==null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不可变动
        HeroNode temp = head.getNext();
        while(true){
            //判断是否到链表最后
            if(temp==null){
                break;
            }
            System.out.println(temp);
            //指向下一个链表对象
            temp=temp.getNext();
        }
    }

}

class HeroNode{
    private Integer no;//编号
    private String name;//姓名
    private String nickname;//绰号

    private HeroNode next;//HeroNode对象

    public HeroNode() {
    }

    public HeroNode(Integer no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
