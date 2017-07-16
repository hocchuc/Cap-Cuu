package com.emc.emergency.core;

import com.emc.emergency.data.model.*;
import com.emc.emergency.data.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * Created by hocan on 23-May-17.
 */
@Component
public class DatabaseLoader implements ApplicationRunner {

    private final userRepository user;
    private final user_typeRepository user_type;
    private final accidentRepository accident;
    private final chatRepository chat;
    private final imageRepository imageRepository;
    private final personal_infoRepository personal_infoRepository;
    private final medical_infoRepository medical_infoRepository;
    private final accident_detailRepository accident_detailRepository;
    private final action_typeRepository action_typeRepository;


        @Autowired
    public DatabaseLoader(userRepository user, user_typeRepository user_type, accidentRepository accident, chatRepository chat, imageRepository imageRepository, personal_infoRepository personal_infoRepository, medical_infoRepository medical_infoRepository, accident_detailRepository accident_detailRepository, action_typeRepository action_typeRepository) {
        this.user = user;
        this.user_type = user_type;
        this.accident = accident;
        this.chat = chat;
        this.imageRepository = imageRepository;
        this.personal_infoRepository = personal_infoRepository;
        this.medical_infoRepository = medical_infoRepository;
        this.accident_detailRepository = accident_detailRepository;
        this.action_typeRepository = action_typeRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {


        User_Type admin = new User_Type(null,"admin");
        User_Type volunteer = new User_Type(null,"volunteer");
        User_Type user_normal = new User_Type(null,"user");
        user_type.save(admin);
        user_type.save(volunteer);
        user_type.save(user_normal);

        User user1 = new User(null,"hocanhchuc@gmail.com",user_type.findOne(1l), "123456",null,10.712746, 106.614751);
        User user2 = new User(null,"trancaotri@gmail.com",user_type.findOne(1l), "123456",null,10.777437, 106.630484);
        User user3 = new User(null,"diemhang@gmail.com",user_type.findOne(2l), "123456",null,10.780200, 106.629210);
        User user4 = new User(null,"trantrungduong@gmail.com",user_type.findOne(2l), "123456",null,10.780040, 106.629250);
        User user5 = new User(null,"truongminhhoang@gmail.com",user_type.findOne(3l), "123456",null,10.782240, 106.623230);
        User user6 = new User(null,"huynhthanhtrung@gmail.com",user_type.findOne(3l), "123456",null,10.780010, 106.629550);
        user.save(user1);
        user.save(user2);
        user.save(user3);
        user.save(user4);
        user.save(user5);
        user.save(user6);

        Accident accident1 = new Accident(null,user.findOne(1l),"Gãy lưng",new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss a").parse("10/06/2017 at 10:10:15 AM"),Double.parseDouble("10.766622"),Double.parseDouble("106.642844"),"Pending",null,null,"87 Ông Ích Khiêm, phường 10, Quận 11, Hồ Chí Minh, Việt Nam",null);
        accident.save(accident1);

        Accident accident2 = new Accident(null,user.findOne(1l),"Té xe ",new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss a").parse("11/06/2017 at 02:10:15 PM"),Double.parseDouble("10.781785"),Double.parseDouble("106.643036"),"Pending",null,null,"541 Âu Cơ, Phú Trung, Tân Phú, Hồ Chí Minh",null);
        accident.save(accident2);

        Accident accident3 = new Accident(null,user.findOne(3l),"Chó cắn",new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss a").parse("11/06/2017 at 02:10:15 PM"),Double.parseDouble("10.799555"),Double.parseDouble("106.637219"),"Pending",null,null,"15-16 Âu Cơ, phường 14, Tân Phú, Hồ Chí Minh",null);
        accident.save(accident3);

        //Accident accident4 = new Accident(null,user.findOne(3l),"Té cầu thang",new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss a").parse("11/06/2017 at 02:10:15 PM"),Double.parseDouble("10.783994"),Double.parseDouble("106.636266"),"Pending",null,null,"763 Lũy Bán Bích Hoà Thạnh Tân Phú Hồ Chí Minh",null);
        //accident.save(accident4);
        //
        //Accident accident5 = new Accident(null,user.findOne(2l),"Đau tim",new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss a").parse("11/06/2017 at 02:10:15 PM"),Double.parseDouble("10.7123"),Double.parseDouble("106.613"),"Pending",null,null,"Số 454 Âu Cơ Tân Binh Hồ Chí Minh",null);
        //accident.save(accident5);
        //
        //Accident accident6 = new Accident(null,user.findOne(2l),"Té xe",new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss a").parse("11/06/2017 at 02:10:15 PM"),Double.parseDouble("10.7142"),Double.parseDouble("106.644"),"Pending",null,null,"Số 433 Âu Cơ Tân Binh Hồ Chí Minh",null);
        //accident.save(accident6);

        Personal_Infomation p1 = new Personal_Infomation(null,null,"Chúc Anh Học",true,new SimpleDateFormat("dd/MM/yyyy").parse("10/09/1995"),"252956865l","Từ Dữ","0909999999","Phu Tho Hoa","chucanhhoc@gmail.com",user.findOne(1l));
        personal_infoRepository.save(p1);

        Personal_Infomation p2 = new Personal_Infomation(null,null,"Trần Cao Trí",true,new SimpleDateFormat("dd/MM/yyyy").parse("20/06/1995"),"252416865l","115","0909999119","Thach Lam","trancaotri@gmail.com",user.findOne(2l));
        personal_infoRepository.save(p2);

        Personal_Infomation p3 = new Personal_Infomation(null,null,"Lê Diễm Hàng",false,new SimpleDateFormat("dd/MM/yyyy").parse("19/06/1995"),"2524456865l","Chương Dương","0909999113","HIền Vương","diemhang@gmail.com",user.findOne(3l));
        personal_infoRepository.save(p3);

        Personal_Infomation p4 = new Personal_Infomation(null,null,"Trần Trung Dương",false,new SimpleDateFormat("dd/MM/yyyy").parse("20/16/1995"),"25244568756","Bệnh Viện Quận 6","0909999213","Cao Lỗ ","trantrungduong@gmail.com",user.findOne(4l));
        personal_infoRepository.save(p4);

        Personal_Infomation p5 = new Personal_Infomation(null,null,"Trương Minh Hoàng",false,new SimpleDateFormat("dd/MM/yyyy").parse("30/08/1995"),"25244568123","Công ty GPS","0909999222","Bình Long","truongminhhoang@gmail.com",user.findOne(5l));
        personal_infoRepository.save(p5);

        Personal_Infomation p6 = new Personal_Infomation(null,null,"Huỳnh Thanh Trung",false,new SimpleDateFormat("dd/MM/yyyy").parse("20/8/1995"),"25244568333","Công ty Technik","0909999654","Long An","huynhthanhtrung@gmail.com",user.findOne(6l));
        personal_infoRepository.save(p6);

        Medical_Info m1 = new Medical_Info(null,personal_infoRepository.findOne(0L),"panadol",1,"thuoc dau dau");
        medical_infoRepository.save(m1);
        Medical_Info m1_2 = new Medical_Info(null,personal_infoRepository.findOne(0L),"Dau dau",2,"dau dau");
        medical_infoRepository.save(m1_2);

        Medical_Info m2 = new Medical_Info(null,personal_infoRepository.findOne(1L),"bioka",1,"thuoc chua ung thu");
        medical_infoRepository.save(m2);

        Medical_Info m2_2 = new Medical_Info(null,personal_infoRepository.findOne(1L),"Ung Thu",2,"ung thu giai doan 1");
        medical_infoRepository.save(m2_2);

        Action_Type action_type1  =new Action_Type(null,"Join");
        Action_Type action_type2  =new Action_Type(null,"SetDone");
        Action_Type action_type3  =new Action_Type(null,"ReportFake");
        Action_Type action_type4  =new Action_Type(null,"ReportTrue");

        action_typeRepository.save(action_type1);
        action_typeRepository.save(action_type2);
        action_typeRepository.save(action_type3);
        action_typeRepository.save(action_type4);




    }
}
