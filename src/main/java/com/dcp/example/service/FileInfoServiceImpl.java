package com.dcp.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcp.example.domain.FileInfo;
import com.dcp.example.mapper.FileInfoMapper;

@Service("FileServiceImpl")
public class FileInfoServiceImpl implements FileInfoService{
	
	@Autowired FileInfoMapper fileinfomapper;
	
	public void saveFileInfo(FileInfo fileInfo) {
		fileinfomapper.saveFileInfo(fileInfo);
	}
	
	public List<FileInfo> getFileInfo(int fMaster) {
		return fileinfomapper.getFileInfo(fMaster);
	}

}
