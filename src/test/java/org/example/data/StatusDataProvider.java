package org.example.data;

import org.testng.annotations.DataProvider;

public class StatusDataProvider {
    @DataProvider
    public Object[][] statusDataProvider(){
        return new Object[][] {
            {
                "available"
            },
            {
                "pending"
            },
                {
                    "sold"
                }
        };
    }
}
