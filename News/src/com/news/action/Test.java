package com.news.action;


import ICTCLAS.I3S.AC.ICTCLAS50;
public class Test {
    public static void haha(){
        try{
            ICTCLAS50 testICTCLAS50 = new ICTCLAS50();
            String argu = ".";
            if(testICTCLAS50.ICTCLAS_Init(argu.getBytes("GB2312")) == false){
                System.out.println("Init Fail");
            }else{
                System.out.println("Init Succeed!");
            }
            
            
            
            
            
            String sInput = "G55广贺高速往广佛高速方向，K2643+500(宾亨站至黄田站路段)，2014年10月07日17时45分，一辆运载木块的小货车因避让不当撞向右侧护栏发生侧翻交通事故，现场超车道可通行，无车龙，21时00分事件仍在进行中。";
            //未导入用户词典
            byte nativeBytes[] = testICTCLAS50.ICTCLAS_ParagraphProcess(sInput.getBytes("GB2312"), 0, 1);
            System.out.println(nativeBytes.length);            
            String nativeStr = new String(nativeBytes,0,nativeBytes.length,"GB2312");
            System.out.println("未导入用户词典分词结果："+nativeStr);
            //导入用户词典
            int nCount = 0;
            String usrdir = "text/userdict.txt";
            byte[] usrdirb = usrdir.getBytes();
            //第一个参数为用户字典路径，第二个参数为用户字典的编码类型(0:type unknown;1:ASCII码;2:GB2312,GBK,GB10380;3:UTF-8;4:BIG5)
            nCount = testICTCLAS50.ICTCLAS_ImportUserDictFile(usrdirb, 2);        
            System.out.println("导入用户词个数："+nCount);
            nCount = 0;            
            //导入用户词典之后再分词
            byte[] nativeBytes1 = testICTCLAS50.ICTCLAS_ParagraphProcess(sInput.getBytes("GB2312"), 0, 1);
            System.out.println(nativeBytes1.length);
            String nativeStr1 = new String(nativeBytes1,0,nativeBytes1.length,"GB2312");
            System.out.println("导入用户词典分词结果："+nativeStr1);
            
            /*
             * ICT_POS_MAP_SECOND  计算所二级标注集   0
             * ICT_POS_MAP_FIRST  计算所一级标注集    1
             * PKU_POS_MAP_SECOND   北大二级标注集    2
             * PKU_POS_MAP_FIRST       北大一级标注集   3
             * */
            //使用计算所二级标注集
            testICTCLAS50.ICTCLAS_SetPOSmap(0);
            byte[] nativeBytes2 = testICTCLAS50.ICTCLAS_ParagraphProcess(sInput.getBytes("GB2312"), 0, 1);
            System.out.println(nativeBytes2.length);
            String nativeStr2 = new String(nativeBytes2,0,nativeBytes2.length,"GB2312");
            System.out.println("计算所二级标注集："+nativeStr2);
            //使用北大二级标注集
            testICTCLAS50.ICTCLAS_SetPOSmap(2);
            byte[] nativeBytes3 = testICTCLAS50.ICTCLAS_ParagraphProcess(sInput.getBytes("GB2312"), 0, 1);
            System.out.println(nativeBytes3.length);
            String nativeStr3 = new String(nativeBytes3,0,nativeBytes3.length,"GB2312");
            System.out.println("北大二级标注集："+nativeStr3);    
            //释放分词组件资源            
            testICTCLAS50.ICTCLAS_Exit();
            
        }catch(Exception ex){
            
        }
        
        
        

        
        
        
        
        
        
        
    }
}