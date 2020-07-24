/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DateConvert;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author vatha
 */
public class SimpleFormat {

    public Date dateFormat(String date) {
        //convert staring to date
        LocalDate dateJava = LocalDate.parse(date);

        //convert date java to sql date
        java.sql.Date dateSql = java.sql.Date.valueOf(dateJava);
        return dateSql;
    }
}
