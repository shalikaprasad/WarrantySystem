package com.sarc.service;

import com.sarc.bean.Head_Company;

import java.io.IOException;
import java.sql.SQLException;

public interface CreatingService {
    void downloadAll() throws IOException, SQLException;
    String saveLogo(Head_Company company) throws SQLException, IOException;
}
