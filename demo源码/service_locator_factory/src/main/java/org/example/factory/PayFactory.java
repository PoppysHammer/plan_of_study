package org.example.factory;

import org.example.service.PayService;

public interface PayFactory {
    PayService getPay(String name);
}
