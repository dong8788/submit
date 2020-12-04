package com.spring.webprj.util;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
 
 public static String fileUpload(String uploadPath,
         String fileName,
         byte[] fileData, String ymdPath) throws Exception {

    //중복되지 않는 uuid 생성
  UUID uid = UUID.randomUUID();
  
     //파일이름 --> "uuid" + "_" + "fileName" 패턴
  String newFileName = uid + "_" + fileName;
  String imgPath = uploadPath + ymdPath;  //이미지경로  --> 업로드경로에 년원일경로

  //서버에 파일 저장 
     //imgPath(uploadPath + ymdPath) 경로에 newFileName("uuid" + "_" + "fileName") 이름을 가진 File타입 target 객체 생성
  File target = new File(imgPath, newFileName);  //파일 객체 생성
     //위에서 만든 target 객체에 매개변수로 받은 fileData 복사
  FileCopyUtils.copy(fileData, target);  //파일 객체에 파일 데이터 복사
   
  return newFileName;
 }
 
 
 // 파일 삭제 처리
 public static void deleteFile(String fileName, HttpServletRequest request) {

     String rootPath = fileName + request; // 기본경로 추출(이미지 or 일반파일)

     // 1. 원본 이미지 파일 삭제
     MediaType mediaType = MediaUtils.getMediaType(fileName);
     if (mediaType != null) {
         String originalImg = fileName.substring(0, 12) + fileName.substring(14);
         new File(rootPath + originalImg.replace('/', File.separatorChar)).delete();
     }

     // 2. 파일 삭제(썸네일이미지 or 일반파일)
     new File(rootPath + fileName.replace('/', File.separatorChar)).delete();
 }

  
 //폴더이름 및 폴더 생성
 public static String calcPath(String uploadPath) {
   // Calandar 싱글톤 객체 생성
  Calendar cal = Calendar.getInstance();
  
     //"/년/월/일" 경로 패턴 설정
  String yearPath = File.separator + cal.get(Calendar.YEAR);
  String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
  String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));

     //실제 해당 경로가 존재하는지 판단 후 생성
  makeDir(uploadPath, yearPath, monthPath, datePath);

  return datePath;
 }

 //폴더 생성
 private static void makeDir(String uploadPath, String... paths) {

   // uploadPath + yearPath + monthPath + datePath. 해당 경로가 존재한다면 메서드 종료
  if (new File(paths[paths.length - 1]).exists()) { return; }

     //yearPath -> monthPath -> datePath 순으로 감
  for (String path : paths) {
   File dirPath = new File(uploadPath + path);

      // 더 깊은 곳의 디렉토리가 존재하지 않는다면 폴더 생성
   if (!dirPath.exists()) {
    dirPath.mkdir();
   }
  }
 }
}