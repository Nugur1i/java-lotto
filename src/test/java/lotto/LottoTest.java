package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    /*@DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }*/

    /*@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }*/

    @DisplayName("로또 번호 string으로 받은 것 List에 넣기")
    @Test
    void changeStringToList() {

        Maker changeStringToList = new Maker();

        assertEquals(changeStringToList.lottoWinList("1,2,3,4,5,6"), List.of(1, 2, 3, 4, 5, 6));
    }


    @DisplayName("6개의 로또 번호를 생성해주는지")
    @Test
    void generateRandomLottoNumber() {

        assertEquals(pickUniqueNumbersInRange(1, 45, 6).size(), 6);

    }

    @DisplayName("돈을 넣은 만큼 로또 번호를 생성하고 그것을 배열에 담는지 확인")
    @Test
    void generateRandomLottoNumberAccordingToInputMoney() {

        Generator generator = new Generator();
        List<List<Integer>> lottoList = generator.generateRandomLottoNumber(14000);

        assertAll(
                () -> assertEquals(lottoList.size(), 14),
                () -> assertEquals(lottoList.get(0).size(), 6)
        );


    }


}
