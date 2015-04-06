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
            
            
            
            
            
            String sInput = "G55��ظ����������ٷ���K2643+500(����վ������վ·��)��2014��10��07��17ʱ45�֣�һ������ľ���С��������ò���ײ���Ҳ໤�������෭��ͨ�¹ʣ��ֳ���������ͨ�У��޳�����21ʱ00���¼����ڽ����С�";
            //δ�����û��ʵ�
            byte nativeBytes[] = testICTCLAS50.ICTCLAS_ParagraphProcess(sInput.getBytes("GB2312"), 0, 1);
            System.out.println(nativeBytes.length);            
            String nativeStr = new String(nativeBytes,0,nativeBytes.length,"GB2312");
            System.out.println("δ�����û��ʵ�ִʽ����"+nativeStr);
            //�����û��ʵ�
            int nCount = 0;
            String usrdir = "text/userdict.txt";
            byte[] usrdirb = usrdir.getBytes();
            //��һ������Ϊ�û��ֵ�·�����ڶ�������Ϊ�û��ֵ�ı�������(0:type unknown;1:ASCII��;2:GB2312,GBK,GB10380;3:UTF-8;4:BIG5)
            nCount = testICTCLAS50.ICTCLAS_ImportUserDictFile(usrdirb, 2);        
            System.out.println("�����û��ʸ�����"+nCount);
            nCount = 0;            
            //�����û��ʵ�֮���ٷִ�
            byte[] nativeBytes1 = testICTCLAS50.ICTCLAS_ParagraphProcess(sInput.getBytes("GB2312"), 0, 1);
            System.out.println(nativeBytes1.length);
            String nativeStr1 = new String(nativeBytes1,0,nativeBytes1.length,"GB2312");
            System.out.println("�����û��ʵ�ִʽ����"+nativeStr1);
            
            /*
             * ICT_POS_MAP_SECOND  ������������ע��   0
             * ICT_POS_MAP_FIRST  ������һ����ע��    1
             * PKU_POS_MAP_SECOND   ���������ע��    2
             * PKU_POS_MAP_FIRST       ����һ����ע��   3
             * */
            //ʹ�ü�����������ע��
            testICTCLAS50.ICTCLAS_SetPOSmap(0);
            byte[] nativeBytes2 = testICTCLAS50.ICTCLAS_ParagraphProcess(sInput.getBytes("GB2312"), 0, 1);
            System.out.println(nativeBytes2.length);
            String nativeStr2 = new String(nativeBytes2,0,nativeBytes2.length,"GB2312");
            System.out.println("������������ע����"+nativeStr2);
            //ʹ�ñ��������ע��
            testICTCLAS50.ICTCLAS_SetPOSmap(2);
            byte[] nativeBytes3 = testICTCLAS50.ICTCLAS_ParagraphProcess(sInput.getBytes("GB2312"), 0, 1);
            System.out.println(nativeBytes3.length);
            String nativeStr3 = new String(nativeBytes3,0,nativeBytes3.length,"GB2312");
            System.out.println("���������ע����"+nativeStr3);    
            //�ͷŷִ������Դ            
            testICTCLAS50.ICTCLAS_Exit();
            
        }catch(Exception ex){
            
        }
        
        
        

        
        
        
        
        
        
        
    }
}