package AbstractFactroy;
//联想产品工厂类
public class LenovoFactroy implements LenvovStyle {
    //获取联想手机方法
    @Override
    public FeaTrue getLenovoPhone() {
        return new LemvovPhone();
    }

    //获取联想显示器方法
    @Override
    public FeaTrue getLenovoDispayer() {
        return new LenvovDispayer();
    }
}
