import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Student implements Comparable<Student>{

        String name;
        int lang;
        int eng;
        int math;

        public Student(String name, int lang, int eng, int math) {
            this.name = name;
            this.lang = lang;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            /**
             * 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서
             */
            if (this.lang == o.lang && this.eng == o.eng && this.math == o.math)
                return this.name.compareTo(o.name);
            /**
             * 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서
             */
            if(this.lang == o.lang && this.eng == o.eng)
                return o.math - this.math;
            /**
             * 국어 점수가 같으면 수학 점수가 감소하는 순서
             */
            if(this.lang == o.lang) {
                return this.eng - o.eng;
            }
            /**
             * 국어 점수가 감소하는 순서
             */
            return o.lang - this.lang;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            Student tmp = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            students.add(tmp);
        }

        Collections.sort(students);

        for (Student student : students) {
            System.out.println(student.name);
        }


    }
}
