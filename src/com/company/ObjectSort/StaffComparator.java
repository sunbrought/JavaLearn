package com.company.ObjectSort;

import java.util.Comparator;

public class StaffComparator implements Comparator<Staff> {
    //不一定要自然排序(升序)，也可以反过来写降序
    @Override
    public int compare(Staff o1, Staff o2) {
      /*  if(o1.getSalary()>o2.getSalary()){
            return -1;
        }else if(o1.getSalary()<o2.getSalary()){
            return 1;
        }
        return 0;
    }*/
        //先按照年龄倒序排，如果年龄相等比较工资
        if(o1.getAge()>o2.getAge()){
            return -1;
        }else if(o1.getAge()<o2.getAge()){
            return 1;
        }
        //能到这儿说明年龄相等，现在比较他们的工资
        if(o1.getSalary()>o2.getSalary()){
            return 1;
        }else if(o1.getSalary()<o2.getSalary()){
            return -1;
        }
        return 0;
    }
}
