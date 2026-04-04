package com.Bus_Reservation_System.Bus_Reservation.service.busservice;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user.BusRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user.BusResponceDTO;
import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Bus;
import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Seat;
import com.Bus_Reservation_System.Bus_Reservation.entity.User;
import com.Bus_Reservation_System.Bus_Reservation.entity.type.SeatType;
import com.Bus_Reservation_System.Bus_Reservation.exception.BusNotFoundException;
import com.Bus_Reservation_System.Bus_Reservation.exception.DataNotCurrectException;
import com.Bus_Reservation_System.Bus_Reservation.repository.BusSystemRepo.BusRepo;
import com.Bus_Reservation_System.Bus_Reservation.repository.BusSystemRepo.SeatRepo;
import com.Bus_Reservation_System.Bus_Reservation.repository.UserReop;
import com.Bus_Reservation_System.Bus_Reservation.service.structer.BusService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class BusServiceImpl implements BusService {
    private final UserReop userReop;
    private final BusRepo busRepo;
    private final SeatRepo seatRepo;


    @Override
    public BusResponceDTO createBus(BusRequestDTO busRequestDTO) {
       Bus bus=busRequestMapping(busRequestDTO,new Bus());
       bus=busRepo.save(bus);

createSeat(bus,busRequestDTO.getTotalSeats());

        return busresponceMapping(bus);
    }

private void createSeat(Bus bus,int totalseat){

    List<Seat> seatList=new ArrayList<Seat>();
    for(int i=1;i<=totalseat;i++){
        Seat seat=new Seat();
        seat.setSeatNo(i);
        seat.setBus(bus);
        if(i%5==0 || (i-1)%5==0){
            seat.setSeatType(SeatType.WINDOW);

        }else {
            seat.setSeatType(SeatType.MIDDLE);

        }
        seatList.add(seat);

    }
    seatRepo.saveAll(seatList);

}

    @Override
    public BusResponceDTO updateBus(Integer id, BusRequestDTO busrequest) {

        Bus bus=busRepo.findById(id).orElseThrow(()->new BusNotFoundException("Bus Not Exception"));

        if(busrequest.getBusNo()!=null  ) {
            bus.setBusNo(busrequest.getBusNo());
        }
        if(busrequest.getBustype()!=null){
            bus.setBustype(busrequest.getBustype());
        }

        if(  busrequest.getTotalSeats()!=null){
            bus.setTotalSeats(busrequest.getTotalSeats());
            seatRepo.deleteAllByBus(bus);
            createSeat(bus,busrequest.getTotalSeats());
        }
        if(busrequest.getConductor()!=null){
            User user= userReop.findById(busrequest.getConductor()).orElseThrow(()-> new UsernameNotFoundException("Conductor Not Found "));
            bus.setConductor(user);
        }
        if(busrequest.getDrivar()!=null){
            User user= userReop.findById(busrequest.getDrivar()).orElseThrow(()-> new UsernameNotFoundException("Driver  Not Found "));
            bus.setDrivar(user);
        }
        return busresponceMapping(busRepo.save(bus));
    }

    @Override
    public void deleteBus(Integer id) {
        Bus bus=busRepo.findById(id).orElseThrow(()->new BusNotFoundException("Bus Not Exception"));
busRepo.delete(bus);
    }

    @Override
    public BusResponceDTO getBus(Integer id) {
        Bus bus=busRepo.findById(id).orElseThrow(()->new BusNotFoundException("Bus Not Exception"));

        return busresponceMapping(bus);
    }

    @Override
    public List<BusResponceDTO> getBuses(Integer pageno, Integer pagesize) {
        Pageable pageable= PageRequest.of(pageno,pagesize);
        Page<Bus> buses= busRepo.findAll(pageable);
      return   buses.getContent().stream().map(bus->busresponceMapping(bus)).toList();
    }

    @Override
    public BusResponceDTO getBusByBusNo(String busNo) {
        Bus bus=busRepo.findByBusNo(busNo.trim().toUpperCase()).orElseThrow(()->new BusNotFoundException("Bus Not Exception"));

        return busresponceMapping(bus);
    }

    private Bus busRequestMapping(BusRequestDTO busrequest,Bus bus ){
        if(busrequest.getBusNo()!=null && busrequest.getTotalSeats()!=null && busrequest.getBustype()!=null) {
            bus.setBusNo(busrequest.getBusNo().trim().toUpperCase());
            bus.setTotalSeats(busrequest.getTotalSeats());
            bus.setBustype(busrequest.getBustype());
        }else {
            throw new DataNotCurrectException("Bus Number or total Seat not found");
        }
        if(busrequest.getConductor()!=null){
            User user= userReop.findById(busrequest.getConductor()).orElseThrow(()-> new UsernameNotFoundException("Conductor Not Found "));
            bus.setConductor(user);
        }
        if(busrequest.getDrivar()!=null){
            User user= userReop.findById(busrequest.getDrivar()).orElseThrow(()-> new UsernameNotFoundException("Driver  Not Found "));
            bus.setDrivar(user);
        }
        return bus;
    }

    private BusResponceDTO busresponceMapping(Bus bus){
        BusResponceDTO busResponceDTO = new BusResponceDTO();
        if(bus.getBusNo()!=null){
            busResponceDTO.setBusNo(bus.getBusNo());
        }
        if(bus.getTotalSeats()!=null){
            busResponceDTO.setTotalSeats(bus.getTotalSeats());
        }
        if(bus.getBustype()!=null){
            busResponceDTO.setBustype(bus.getBustype());
        }
        if(bus.getConductor()!=null){
            busResponceDTO.setConductor(bus.getConductor());
        }
        if(bus.getDrivar()!=null){
            busResponceDTO.setDrivar(bus.getDrivar());
        }
        if(bus.getId()!=null){
            busResponceDTO.setId(bus.getId());
        }
        busResponceDTO.setStatus(bus.isStatus());

        return  busResponceDTO;
    }
}
