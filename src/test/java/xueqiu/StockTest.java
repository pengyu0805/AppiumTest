package xueqiu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.net.MalformedURLException;

public class StockTest {
    static MainPage mainPage;
    static SearchPage searchPage;
    static StockPage stockPage;

    @BeforeAll
    public void beforeAll() throws MalformedURLException {
        stockPage=new MainPage().toStock();
        //todo 增加自选股是否为空的处理
        stockPage.deleteAllStock();
    }

    @ParameterizedTest
    @CsvSource({
            "alibaba,阿里巴巴",
            "jd,京东",
            "tengxunkonggu,腾讯控股"
    })
    void addStock(String keyword,String name){

        stockPage.addStock(name);

    }
}
