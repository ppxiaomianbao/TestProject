package AbstractFactroy;
//产品工厂类，获取不同品牌产品
public class EelctronicsFactroy implements Electronics {

    //获取联想品牌产品
    @Override
    public LenvovStyle getLenovo() {
        return new LenovoFactroy();
    }

    //获取小米品牌产品
    @Override
    public MiUiStyle getMiUI() {
        return new MiUiFactroy();
    }
}
