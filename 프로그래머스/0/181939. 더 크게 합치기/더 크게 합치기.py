def solution(a, b):
    ans1 = int(str(a)+str(b))
    ans2 = int(str(b)+str(a))
        
    return ans1 if ans1>=ans2 else ans2