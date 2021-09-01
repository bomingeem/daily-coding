package bomingeem.dailycoding;

public class GreatestCommonDivisor {
    //최대공약수 구하기 = 두 자연수의 공통된 약수 중 가장 큰 수를 의미
    //약수: 자연수 a,b가 있을 때 a를 b로 나누었을 때 나머지가 0이면 b를 a의 약수라 한다.
    public static void main(String[] args) {
        System.out.println(GCD(12, 20));
    }

    static int GCD(int a, int b) {
        //1. 유클리드 호제법
        while (b != 0) {
            int r = a%b;
            a = b;
            b = r;
        }
        return a;

        //2. 재귀함수 이용
        // if (a%b == 0) return b;
        // return GCD(b, a%b);
    }
}
