package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CompareHowManyCorrect {
    private List<Integer> returnList = new ArrayList<>();



    public List<Integer> correctNumberList(List<List<Integer>> user, List<Integer> winNumber, int bounsNumber){

        for (int i = 0 ; i < user.size(); i ++) {
            List<Integer> listsCombination = gatherTwoLists(user.get(i),winNumber);
            returnList.add(caculateCorrect(listsCombination,bounsNumber));
        }

        return returnList;
    }

    public int caculateCorrect(List<Integer> listsCombination, int bounsNumber){

        int removeDuplicationSize = new HashSet(listsCombination).size();
        int correctNumber = listsCombination.size() - removeDuplicationSize;

        if (correctNumber == 6 || (correctNumber == 5 && checkBonus(listsCombination,bounsNumber))){
            correctNumber++; // 겹치는 숫자 개수를 나중에 인덱스로 사용하기 위해, '6개 겹치는 경우'와 '5개 겹치고 1개 보너스인 경우'에 +1을 하여 구분 지었음.
        }

        return correctNumber;
    }


    public List<Integer> gatherTwoLists(List<Integer> user, List<Integer> winNumber){
        returnList.addAll(user);
        returnList.addAll(winNumber);
        return returnList;
    }

    public boolean checkBonus(List<Integer> user, int bounsNumber){
        return user.contains(bounsNumber);
    }







}
