package com.dcp.example.service;

import java.util.List;

import com.dcp.example.domain.FileInfo;

public interface FileInfoService {
	
	public void saveFileInfo(FileInfo fileInfo);
	
	public List<FileInfo> getFileInfo(int fMaster);
}
