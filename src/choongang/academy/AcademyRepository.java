package choongang.academy;

import java.util.List;

public class AcademyRepository {
    private static List<LectureManagement> lectureList;

    static {
        lectureList = List.of(new LectureManagement[]{
                new searchLecList("JAVA 입문", "김기범",
                        20230403, 210810),
                new searchLecList("C언어 입문", "전현무",
                        20230408, 320000),
                new searchLecList("인공지능 이해, 챗봇만들기", "박나래",
                        20230415, 600000),
                new searchLecList("드론 프로그래밍", "한혜진",
                        20230429, 390000),
                new searchLecList("증강/가상현실 프로그래밍", "하현태",
                        20230503, 600000),
                new searchLecList("SW기업 입사 코딩테스트 대비반", "홍순구",
                        20230512, 500000),
                new searchLecList("코딩테스트와 개발실무를 모두 잡는 알고리즘", "김희민",
                        20230517, 240000),
                new searchLecList("Android APP", "장보고",
                        20230408, 320000),
                new searchLecList("R기반 빅데이터 분석, 시각화", "이장우",
                        202300429, 210000),
                new searchLecList("CUDA GPU 프로그래밍", "최화사",
                        20230415, 900000),
                new searchLecList("정보처리기사 실기 대비반", "무지개",
                        20230415, 120000)

        });
    }
    public static List<LectureManagement> lecturListForPayroll() {
        return lectureList;
    }


    // 학생조회

        /**
         * 강의 전체조회
         */

    public void getLectureList() {
        System.out.printf("============== 개설된 강의현황 (총 %d개) ============\n"
                , lectureList.size());
        System.out.println("※   강의명   |   강사명   |   개강일   |   수강료   ※");
        for (LectureManagement lm : lectureList) {
            System.out.println(lm.lecInform());
        }

        /**
         * 강의 선택조회
         * */




        /**
         * 강의별 수강생 리스트
         * */


    }


}
// 새 강의 개설


