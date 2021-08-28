package com.zh.leetcode.test;

public class Test {
    public static void main(String[] args) {
        f1();
    }

    private static void f1(){
        String pre = "INSERT INTO `gateway`.`term_info`(`term_id`, `term_name`, `merchant_id`, `sub_merchant_id`, `note`, `privateKey`, `publicKey`, `is_check_sign`) VALUES ('";
//                +"1F0RW5UENI"+
        String aft ="', NULL, '2021020801', '20210208562918', NULL, 'MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJxFBRHX7VUdHp0xi5EMz6SFlf/KHUwe25YLQPQwlAEzoki12Lf1A7BdDoL8spQKVqUE+mu11MYeRezwDCR2InN8WW8vponaY+2Q83fGzCkWbZmODOwOCCcQkdpcTs7oYEzoH61pa8KpAOnBGyFTEj+Ov72nE0F/DjXF5XDFnv4jAgMBAAECgYBQhdgo66Tl2M1vnpoWMg3E7vjuB021bakk1cOwkF+ThvG2mc2EbQJrnGff4yp50iH3gmsvmVB8jhjmEIORPjZdkaWNh0klnlmcC54YYr3WYoq4V+Yjp7LWwkMVT355rWBP3hb2M5Lvy9Olk96RxRvmfP3Bc1KZ2Mt7En8GvK4EUQJBAMyQ6skpHCQS751fjSjSLnYiOeKfCatXGa9JGLvlepfScSzHduIJa2UdH7bieyOSmva6Ur7UAFeayL5v+uJVRh8CQQDDj3S7duMcUBgvwJT2zitSV2PVluJTeyKJdowG1+hZ//A2OKjyoI2FokBFpx4lFdHMXx/KHvtyVoth5U/Vwh99AkAwyyA1eyjLMfkVgIUbB4cthlxoQab8x3nI5ZaQutvS+s8j7y/cGoMTSy8VYFAe3Ak6cJbsDYVHYBQh2HPvKIfhAkAFuScTbXFMHNP4Ycx6RKJj8IbNc3MAOnRSTZPfh2YXbDQdgh7/qs85f/wdjbyGHVNchdQqWCnHuNyvasShXuMJAkA/ssml8jOX901xwOkyAoddzIrQZkP19OnSN/+gVCMwKLF5r2mNg340bEBKzBXdKQ+2XT7rTD8uqS6HkWQ+mAqW', 'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCcRQUR1+1VHR6dMYuRDM+khZX/yh1MHtuWC0D0MJQBM6JItdi39QOwXQ6C/LKUClalBPprtdTGHkXs8AwkdiJzfFlvL6aJ2mPtkPN3xswpFm2ZjgzsDggnEJHaXE7O6GBM6B+taWvCqQDpwRshUxI/jr+9pxNBfw41xeVwxZ7+IwIDAQAB', '1');\n";

        String str = "245DFC6BBDF4\n" +
                "245DFC6BBCD9\n" +
                "245DFC6BBA05\n" +
                "245DFC6BBDAB\n" +
                "245DFC6BBDE8\n" +
                "245DFC6BBD8F\n" +
                "245DFC6BBCDC\n" +
                "245DFC6BBD9E\n" +
                "245DFC6BBCEB";
        String []strings = str.split("\n");
        for (String s : strings
             ) {
            System.out.println(pre+s+aft);
        }



    }
}
