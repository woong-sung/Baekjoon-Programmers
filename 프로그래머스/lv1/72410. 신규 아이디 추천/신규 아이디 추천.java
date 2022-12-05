class Solution {
		public String solution(String new_id) {
			String answer = new_id;

			// 1단계
			answer = answer.toLowerCase();
			// 2단계
			answer = answer.replaceAll("[^0-9a-z-_.]", "");
			// 3단계 
			answer = answer.replaceAll("\\.{2,}", ".");
			// 4단계
			answer = answer.replaceAll("^[\\.]|[\\.]$", "");
			// 5단계
			if (answer.equals("")) {
				answer = "a";
			}
			// 6단계
			if (answer.length() > 15) {
				if (answer.charAt(14) == '.') {
					answer = answer.substring(0, 14);
				} else {
					answer = answer.substring(0, 15);
				}
			}
			// 7단계
			while (true) {
				if (answer.length() <= 2) {
					answer += answer.charAt(answer.length() - 1);
				} else
					break;
			}

			return answer;
		}
	}