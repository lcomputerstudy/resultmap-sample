package com.dcp.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dcp.example.domain.FileInfo;

@Mapper
public interface FileInfoMapper {
	
	public void saveFileInfo(FileInfo fileInfo);
	
	public List<FileInfo> getFileInfo(int fMaster);
}
