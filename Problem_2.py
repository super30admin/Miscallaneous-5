# from Collections import deque

def removeCharacters(string, count):
    stack = []
    result = ''
    for i in range(len(string)):
        if len(stack) != 0:
            if stack[-1][0] == string[i]:
                stack[-1][1] += 1
            else:
                if stack[-1][1] > count:
                    stack.pop()
                if stack[-1][0] == string[i]:
                    stack[-1][1] += 1
                    if stack[-1][1] > count:
                        stack.pop()
                else:
                    stack.append([string[i], 1])
        else:
            stack.append([string[i], 1]);

    
    if stack[-1][1] > count:
        stack.pop()

    while len(stack):
        pair = stack.pop()
        while pair[1] > 0:
            result += pair[0]
            pair[1] -= 1       
    return result[::-1]

str1 = 'abba'
str2 = 'abbb'
str3 = 'abbbaa'
str4 = 'abbacccaa'
count = 2
print(removeCharacters(str1, count))
print(removeCharacters(str2, count))
print(removeCharacters(str3, count))
print(removeCharacters(str4, count))

# Time Complexity: O(n)
# Space Complexity: O(n)