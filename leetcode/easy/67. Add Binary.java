        StringBuilder sb = new StringBuilder();
        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;
        int stack = 0;

        while (aIdx >= 0 || bIdx >= 0) {
            int sum = stack;
            if (bIdx >= 0) {
                sum += b.charAt(bIdx) - '0';
                bIdx--;
            }
            if (aIdx >= 0) {
                sum += a.charAt(aIdx) - '0';
                aIdx--;
            }
            sb.append(sum % 2);
            stack = sum / 2;
        }
        if(stack != 0) {
            sb.append(stack);
        }
        return sb.reverse().toString();
