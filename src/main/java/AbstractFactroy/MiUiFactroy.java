package AbstractFactroy;

//小米产品工厂类
public class MiUiFactroy implements MiUiStyle {
    //获取小米手机方法
    @Override
    public FeaTrue getMiUiPhone() {
        return new MiUiPhone();
    }

    //获取小米显示器方法
    @Override
    public FeaTrue getMiUiDisplayer() {
        return new MiUiDisplayer();
    }

    //获取小米充电器方法
    @Override
    public FeaTrue getMiUICharger() {
        return new MiUICharger();
    }
}
