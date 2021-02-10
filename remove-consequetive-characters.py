# TIME COMPLEXITY: O(N)
# SPACE COMPLEXITY: O(N)

def removeContinuous(s):
    # Use a stack to keep track of incoming characters and relative frequency
    st = []
    for ch in s:
        # If the incoming character is equal to top of stack
        if st and st[-1][0] == ch:
            # Check the relative frequency
            count = st[-1][1] + 1
            # If it is > 2, pop
            if count > 2:
                while st and count != 1:
                    st.pop()
                    count -= 1
            else:
                # Push the character along with it's relative frequency on the stack
                st.append((ch, count))
        else:
            st.append((ch, 1))
    res = ""
    # Extract the character from stack and build output string
    for ch, count in st:
        res += ch
    return res


def main():
    print(removeContinuous('abb'))
    print(removeContinuous('abbb'))
    print(removeContinuous('abbbaa'))


main()
