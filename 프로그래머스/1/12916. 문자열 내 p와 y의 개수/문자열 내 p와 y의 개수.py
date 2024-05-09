def solution(s):
    upperS = s.upper()
    countP = 0;
    countY = 0;
    for char in upperS :
        if char == "P":
            countP+=1
        elif char == "Y":
            countY+=1
    if countP==countY : return True
    else : return False
    