import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] sdoku;
	static int[][] mini;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 주어진 스도쿠판
		sdoku = new int[10][10];
		for (int i = 1; i <= 9; i++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				 sdoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 빈칸에 1~9까지 입력
		run(1, 1);

	}

	static void run(int o, int p) throws IOException {
		//종료조건 모든 행렬을 다채웠을때
		if (o == 9 && p == 10) {
			for (int i = 1; i <= 9; i++) {
				for (int j = 1; j <= 9; j++) {
					bw.write(sdoku[i][j]+" ");
				}
				bw.newLine();
			}
			bw.flush();
			bw.close();
			System.exit(0);
		}
		//한 행을 다채우면 다음열로 넘어간다
		if (p == 10) {
			run(o + 1, 1);
			return;
		}
		// 다채울때까지 아래 실행
		// 해당칸이 빈칸이라면
		if (sdoku[o][p] == 0) {
			//해당칸에 둘 수 있는가 확인하기
			for (int c = 1; c <= 9; c++) {
				//해당칸을포함하는 작은 3*3 찾기
				mini(o, p);
				if (chk(o, p, c) == true) {
					//만족하면 해당칸은 c로 두기
					sdoku[o][p] = c;
					//그 옆칸 실행
					run(o, p + 1);
				}
			}
			//해당칸에 둘 수 없다면
//			다시 해당칸을 0으로 만들고 그 전 칸 실행
//			해당칸을 0으로 만드는 이유는 1칸뒤로 갔을때는
//			어차피 해당칸이 0이라 상관없지만
//			2칸이상 뒤로가면 해당칸이 잘못된 값으로 채워져있어서
//			초기화를 켜줘야하기 때문
			sdoku[o][p] = 0;
			return;
		}
		//해당칸이 빈칸이 아니라면 옆칸 실행
		run(o, p + 1);
	}

	// 둘 수 있는 지 확인
	static boolean chk(int o, int p, int c) {
		// 1 행비교
		for (int i = 1; i <= 9; i++) {
			if (sdoku[o][i] == c) {
				return false;
			}
		}

		// 2 열비교
		for (int i = 1; i <= 9; i++) {
			if (sdoku[i][p] == c) {
				return false;
			}
		}
		// 3 미니비교
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				if (mini[i][j] == c) {
					return false;
				}
			}
		}

		// 놓을 수 있으면 t 없으면 f
		return true;
	}

	// 미니생성
	static void mini(int o, int p) {
		mini = new int[4][4];
		if (o < 4) {
			if (p < 4) {
				for (int i = 1; i <= 3; i++) {
					for (int j = 1; j <= 3; j++) {
						mini[i][j] = sdoku[i][j];
					}
				}
			} else if (4 <= p && p < 7) {
				for (int i = 1; i <= 3; i++) {
					for (int j = 4; j <= 6; j++) {
						mini[i][j - 3] = sdoku[i][j];
					}
				}
			} else if (7 <= p && p < 10) {
				for (int i = 1; i <= 3; i++) {
					for (int j = 7; j <= 9; j++) {
						mini[i][j - 6] = sdoku[i][j];
					}
				}
			}
		} else if (4 <= o && o < 7) {
			if (p < 4) {
				for (int i = 4; i <= 6; i++) {
					for (int j = 1; j <= 3; j++) {
						mini[i - 3][j] = sdoku[i][j];
					}
				}
			} else if (4 <= p && p < 7) {
				for (int i = 4; i <= 6; i++) {
					for (int j = 4; j <= 6; j++) {
						mini[i - 3][j - 3] = sdoku[i][j];
					}
				}
			} else if (7 <= p && p < 10) {
				for (int i = 4; i <= 6; i++) {
					for (int j = 7; j <= 9; j++) {
						mini[i - 3][j - 6] = sdoku[i][j];
					}
				}
			}
		} else if (7 <= o && o < 10) {
			if (p < 4) {
				for (int i = 7; i <= 9; i++) {
					for (int j = 1; j <= 3; j++) {
						mini[i - 6][j] = sdoku[i][j];
					}
				}
			} else if (4 <= p && p < 7) {
				for (int i = 7; i <= 9; i++) {
					for (int j = 4; j <= 6; j++) {
						mini[i - 6][j - 3] = sdoku[i][j];
					}
				}
			} else if (7 <= p && p < 10) {
				for (int i = 7; i <= 9; i++) {
					for (int j = 7; j <= 9; j++) {
						mini[i - 6][j - 6] = sdoku[i][j];
					}
				}
			}
		}
	}

}