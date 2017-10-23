package com.epam.courses.jf.practice.akunats.second;

import com.epam.courses.jf.practice.common.second.ITestableTask3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Task3 implements ITestableTask3 {
    public List<String> sortPoems(Set<IPoem> poems, String author) {
        List<String> result = new ArrayList<>();
        for (IPoem poem : poems) {
            if (poem.getAuthor().equals(author)) {
                result = poem.getLines().stream()
                        .sorted(Comparator.comparingInt(String::length))
                        .collect(Collectors.toList());
            }
        }
        return result;
    }
}