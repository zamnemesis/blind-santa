package com.zam.util;

import com.zam.bean.Pair;
import com.zam.bean.Participant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

/**
 * author tarasenko
 * since  12.01.2018
 */
public class Shuffler {
    public static List<Pair> makePairs(List<Participant> participants) {
        if (isEmpty(participants)) {
            throw new RuntimeException("There are no participants");
        }

        if (participants.size() == 1) {
            throw new RuntimeException("There must be more than 1 participant");
        }

        List<Pair> pairs = new ArrayList<>(participants.size());
        Collections.shuffle(participants);

        for (int i = 0; i < participants.size(); i++) {

            Pair pair =
                    i == participants.size() - 1
                            ?
                            new Pair(participants.get(i), participants.get(0))
                            :
                            new Pair(participants.get(i), participants.get(i + 1));
            pairs.add(pair);
        }
        return pairs;
    }
}
