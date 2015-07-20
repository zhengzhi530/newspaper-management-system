package npp.impl.service;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import npp.dto.ReminderDto;
import npp.spec.dao.ReminderDao;
import npp.spec.dao.Transaction;
import npp.spec.service.ReminderService;


public class ReminderServiceImpl implements ReminderService, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1528029305275870761L;
	private Transaction transaction;
	private ReminderDao dao;

	@Inject
	public ReminderServiceImpl(Transaction transaction, ReminderDao dao){
		this.transaction =  transaction;
		this.dao = dao;
	}

	@Override
	public ReminderDto findBySeq(int seq) throws IOException{
		try{
			transaction.begin();
			ReminderDto dto = dao.findBySeq(transaction, seq);
			transaction.commit();
			return dto;
		}catch (IOException e){
			transaction.rollback();
			throw e;
		}
	}

	@Override
	public List<ReminderDto> getAllList() throws IOException{
		try{
			transaction.begin();
			List<ReminderDto> List = dao.getAllList(transaction);
			transaction.commit();
			return List;
		}catch(IOException e){
			transaction.rollback();
			throw e;
		}
	}

	@Override
	public void add(ReminderDto dto) throws IOException {
		try{
			transaction.begin();
			dao.add(transaction, dto);
			transaction.commit();
		}catch(IOException e){
			transaction.rollback();
			throw e;
		}
	}

	@Override
	public void update(ReminderDto dto) throws IOException {
		try{
			transaction.begin();
			dao.update(transaction, dto);
			transaction.commit();
		}catch(IOException e){
			transaction.rollback();
			throw e;
		}
	}

	@Override
	public void delete(int seq) throws IOException {
		try{
			transaction.begin();
			dao.delete(transaction, seq);
			transaction.commit();
		}catch(IOException e){
			transaction.rollback();
			throw e;
		}
	}

	@Override
	public ReminderDto findByName(String name) throws IOException {
		try{
			transaction.begin();
			ReminderDto dto = dao.findByName(transaction, name);
			transaction.commit();
			return dto;
		}catch(IOException e){
			transaction.rollback();
			throw e;
		}
	}

}
