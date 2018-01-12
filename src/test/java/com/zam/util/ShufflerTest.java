package com.zam.util;

import com.zam.bean.Pair;
import com.zam.bean.Participant;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * author tarasenko
 * since  12.01.2018
 */
public class ShufflerTest {

    @Test
    public void makePairsSuccessfully() throws Exception {
        List<Participant> list = init(5);
        List<Pair> pairs = Shuffler.makePairs(list);
        printPairs(pairs);
    }

    @Test (expected = RuntimeException.class)
    public void makePairFromEmptyList() throws Exception{
        List<Participant> list = init(0);
        List<Pair> pairs = Shuffler.makePairs(list);
        printPairs(pairs);
    }

    @Test (expected = RuntimeException.class)
    public void makePairFromListWithSingleParticipant() throws Exception{
        List<Participant> list = init(1);
        List<Pair> pairs = Shuffler.makePairs(list);
        printPairs(pairs);
    }

    private List<Participant> init(int size) {
        List<Participant> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Participant participant = new Participant("mail_" + i + "@gmail.com", "name_" + i);
            list.add(participant);
        }
        return list;
    }

    private void printPairs(List<Pair> pairs) {
        for (Pair pair : pairs) {
            System.out.println(pair);
        }
    }
}