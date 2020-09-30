package com.spring.demo01;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: J03_CompositeObj
 * Description:
 * Date: 2020年09月30日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class J03_CompositeObj {
    private String name;
    private Integer salary;

    private J01_Car car1;
    private List<String> stringList;
    private List<J01_Car> carList;

    private Set<String> stringSet;
    private Set<J01_Car> carSet;

    private Map<String, String> stringMap;
    private Map<String, J01_Car> stringCarMap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public J01_Car getCar1() {
        return car1;
    }

    public void setCar1(J01_Car car1) {
        this.car1 = car1;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public List<J01_Car> getCarList() {
        return carList;
    }

    public void setCarList(List<J01_Car> carList) {
        this.carList = carList;
    }

    public Set<String> getStringSet() {
        return stringSet;
    }

    public void setStringSet(Set<String> stringSet) {
        this.stringSet = stringSet;
    }

    public Set<J01_Car> getCarSet() {
        return carSet;
    }

    public void setCarSet(Set<J01_Car> carSet) {
        this.carSet = carSet;
    }

    public Map<String, String> getStringMap() {
        return stringMap;
    }

    public void setStringMap(Map<String, String> stringMap) {
        this.stringMap = stringMap;
    }

    public Map<String, J01_Car> getStringCarMap() {
        return stringCarMap;
    }

    public void setStringCarMap(Map<String, J01_Car> stringCarMap) {
        this.stringCarMap = stringCarMap;
    }

    @Override
    public String toString() {
        return "CompositeObj{" +
                "name='" + name + '\'' +
                "\n\t\t\t, salary=" + salary +
                "\n\t\t\t, car1=" + car1 +
                "\n\t\t\t, stringList=" + stringList +
                "\n\t\t\t, carList=" + carList +
                "\n\t\t\t, stringSet=" + stringSet +
                "\n\t\t\t, carSet=" + carSet +
                "\n\t\t\t, stringMap=" + stringMap +
                "\n\t\t\t, stringCarMap=" + stringCarMap +
                '}';
    }
}
