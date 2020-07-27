package com.yaoyao.lesson001.demo05;

/**
 * ClassName: PersonModel
 * Description:
 * Date: 2020年07月27日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class PersonModel {
    private UserModel userModel;
    private CarModel carModel;

    public PersonModel() {
    }

    public PersonModel(UserModel userModel, CarModel carModel) {
        this.userModel = userModel;
        this.carModel = carModel;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    @Override
    public String toString() {
        return "PersonModel{" +
                "userModel=" + userModel +
                ", carModel=" + carModel +
                '}';
    }
}
