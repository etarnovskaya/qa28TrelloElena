package com.elena.qa.fw;

import com.elena.qa.model.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListHelper extends HelperBase {
    public ListHelper(WebDriver wd) {
        super(wd);
    }

    public void addNew(){
        click(By.cssSelector(".js-add-list"));
    }

    public  void typeName(List list){
       type(By.name("name"), list.getName());
    }

    public void saveEdit(){
        click(By.cssSelector(".js-save-edit"));
    }
}
