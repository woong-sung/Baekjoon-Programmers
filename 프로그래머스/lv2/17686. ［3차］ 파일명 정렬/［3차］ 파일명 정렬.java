import java.util.*;

class Solution {
        class File {
            String HEAD;
            int NUMBER;
            String TAIL;
            int idx;
 
            void set(String head, int number, String tail, int idx) {
                this.HEAD = head;
                this.NUMBER = number;
                this.TAIL = tail;
                this.idx = idx;
            }

            String getHEAD() {
                return this.HEAD;
            }

            int getNUMBER() {
                return this.NUMBER;
            }

            String getTAIL() {
                return this.TAIL;
            }

            int getIdx(){
                return this.idx;
            }
        }

        public String[] solution(String[] files) {
            String[] answer = new String[files.length];
            File[] fileArr = new File[files.length];

            for (int i = 0; i < files.length; i++) {
                File temp = new File();
                String[] arr = find(files[i]);
                temp.set(arr[0].toLowerCase(), Integer.parseInt(arr[1]), arr[2],i);
                fileArr[i] = temp;
            }

            Arrays.sort(fileArr, new Comparator<File>() {
                public int compare(File f1, File f2) {
                    if(f1.getHEAD().equals(f2.getHEAD())){
                        if (f1.getNUMBER() == f2.getNUMBER()){
                            if(f1.getIdx()>f2.getIdx()){
                                return 1;
                            }else{
                                return -1;
                            }
                        }else{
                            if(f1.getNUMBER() > f2.getNUMBER()){
                                return 1;
                            }else{
                                return -1;
                            }
                        }
                    }
                    else {
                        return f1.getHEAD().compareTo(f2.getHEAD());
                    }
                }
            });

            for (int i = 0; i < fileArr.length; i++) {
                answer[i] = files[fileArr[i].getIdx()];
            }
            return answer;
        }

        public String[] find(String str) {
            String[] answer = new String[3];
            String head = "";
            String[] numberTail = new String[2];

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                    numberTail = findNumber(str, i);
                    break;
                } else {
                    head += str.charAt(i);
                }
            }
            answer[0] = head;
            answer[1] = numberTail[0];
            answer[2] = numberTail[1];
            return answer;
        }

        public String[] findNumber(String str, int c) {
            String[] answer = new String[2];
            String result = "";
            for (int i = c; i < str.length(); i++) {
                if (i==c+5){
                    answer[1] = findTail(str, i);
                    break;
                }
                if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                    result += str.charAt(i);
                } else {
                    answer[1] = findTail(str, i);
                    break;
                }
            }
            answer[0] = result;
            return answer;
        }

        public String findTail(String str, int c) {
            String result = "";
            for (int i = c; i < str.length(); i++) {
                result += str.charAt(i);
            }
            return result;
        }

    }