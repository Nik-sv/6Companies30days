



class Solution {
    // Array for basic numbers
    private final String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    // Array for tens multiples
    private final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    // Array for thousand powers
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder words = new StringBuilder();
        int i = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                String segment = helper(num % 1000).trim();
                if (!segment.isEmpty()) {
                    words.insert(0, segment + " " + THOUSANDS[i] + " ");
                }
            }
            num /= 1000;
            i++;
        }

        return words.toString().trim();
    }

    private String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return LESS_THAN_TWENTY[num];
        } else if (num < 100) {
            return TENS[num / 10] + (num % 10 > 0 ? " " + helper(num % 10) : "");
        } else {
            return LESS_THAN_TWENTY[num / 100] + " Hundred" + (num % 100 > 0 ? " " + helper(num % 100) : "");
        }
    }
}
