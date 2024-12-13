package com.test.service.shuffle.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ShuffleService implements IShuffleService{

    public List<Integer> shuffle(int n) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        shuffle(list);
        return list;
    }

    private void shuffle(List<Integer> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        Random random = new Random();
        for (int i = list.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swap(list, i, j);
        }
    }

    private void swap(List<Integer> list, int i, int j) {
        Integer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
