package com.sarc.service;

import com.sarc.bean.SingerItems;

import java.io.IOException;

public interface UpdatingService {
    void setInvoice(String serial, SingerItems singerItems) throws IOException;
}
