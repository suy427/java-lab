package com.sondahum.servlet.servlet1.repository;


import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class MyRepository1 {
    Map<String, String> instantDB = new LinkedHashMap<>();
}
