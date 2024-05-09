def solution(n):
    answer = 0
    strN = str(n)
    for char in strN :
        answer+= int(char)

    return answer