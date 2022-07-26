using System;
using System.Collections.Generic;
using System.Text;

namespace Array
{
    public class RemoveAdjacentDuplicates
    {
        /*
         * T.C: O(N2) since remove operation cost additional n
         * S.C: O(n) worst case all chars go into the stack
         */
        public string RemoveDuplicates(string s, int k)
        {
            if (s == null || s.Length == 0 || k == 0) return s;

            Stack<int> st = new Stack<int>();

            StringBuilder sb = new StringBuilder(s);

            for (int i = 0; i < sb.Length; i++)
            {
                if (st.Count == 0 || sb[i] != sb[i - 1])
                {
                    st.Push(1);
                }
                else
                {
                    int count = st.Pop();
                    if (count + 1 == k)
                    {
                        sb.Remove(i - k + 1, k);
                        i = i - k;
                    }
                    else
                    {
                        st.Push(count + 1);
                    }
                }

            }

            return sb.ToString();
        }
    }
}
