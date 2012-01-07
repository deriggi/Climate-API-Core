/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.country;

import dao.RowMapper;
import domain.web.Country;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wb385924
 */

public class MinimalCountryRowMapper implements RowMapper<Country>{

    public List<Country> results(ResultSet rs) {
        List<Country> countries = new ArrayList<Country>();
        try {

            while (rs.next()) {
                countries.add(new Country(rs.getString("country_name"), rs.getString("country_iso_3")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CountryRowMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return countries;
    }

}

