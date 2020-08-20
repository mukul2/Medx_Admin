package com.winkcoo.medx.admin.api;


import com.google.gson.JsonElement;
import com.winkcoo.medx.admin.model.AllCollectionWithdraModel;
import com.winkcoo.medx.admin.model.AmbulanceModel;
import com.winkcoo.medx.admin.model.AppointmentModelNew;
import com.winkcoo.medx.admin.model.BillItem;
import com.winkcoo.medx.admin.model.BillSummery;
import com.winkcoo.medx.admin.model.BlogCategoryNameID;
import com.winkcoo.medx.admin.model.ChatModel;
import com.winkcoo.medx.admin.model.CommonUserModel;
import com.winkcoo.medx.admin.model.DeptModel;
import com.winkcoo.medx.admin.model.DistrictModel;
import com.winkcoo.medx.admin.model.DocumentModel;
import com.winkcoo.medx.admin.model.DrEduChInfoModel;
import com.winkcoo.medx.admin.model.DrOnlineServiceModel;
import com.winkcoo.medx.admin.model.LoginResponse;
import com.winkcoo.medx.admin.model.MedicineModel;
import com.winkcoo.medx.admin.model.PrescriptionRequestModel;
import com.winkcoo.medx.admin.model.PrescriptionReviewModel;
import com.winkcoo.medx.admin.model.PublicLatestQueryModel;
import com.winkcoo.medx.admin.model.QueryModel;
import com.winkcoo.medx.admin.model.ServiceNameInfo;
import com.winkcoo.medx.admin.model.ServiceNameRate;
import com.winkcoo.medx.admin.model.SettingsModel;
import com.winkcoo.medx.admin.model.Status;
import com.winkcoo.medx.admin.model.StatusMessage;
import com.winkcoo.medx.admin.model.VideoCallHistoryModel;
import com.winkcoo.medx.admin.model.WitdhdrawFull;

import java.util.List;

public class ApiListener {
    public interface SettingUpdateListener {
        void onSettingUpdateSuccess(StatusMessage response);

        void onSettingUpdateFailed(String msg);
    }

    public interface PaymentListDownloadListener {
        void onPaymentListDownloadSuccess(AllCollectionWithdraModel response);

        void onPaymentListDownloadFailed(String msg);
    }
    public interface allPendingPaymentListDownloadListener {
        void onallPendingPaymentListDownloadSuccess(JsonElement response);

        void onallPendingPaymentListDownloadFailed(String msg);
    }

    public interface AllWitdhdrawListtListDownloadListener {
        void onAllWitdhdrawListDownloadSuccess(List<WitdhdrawFull> response);

        void onAllWitdhdrawListDownloadFailed(String msg);
    }

    public interface AllSettingListtListDownloadListener {
        void onAllSettingListDownloadSuccess(List<SettingsModel> response);

        void onAllSettingListDownloadFailed(String msg);
    }

    public interface BasicApiListener {
        void onBasicAPISuccess(StatusMessage response);

        void onBasicAPIFailed(String msg);
    }

    public interface UserBillDownloadListener {
        void onUserBillDownloadSuccess(List<BillItem> list);

        void onUserBillDownloadFailed(String msg);
    }
    public interface UserBillSummeryDownloadListener {
        void onUserBillSummeryDownloadSuccess(BillSummery list);

        void onUserBillSummeryDownloadFailed(String msg);
    }

    public interface LoginListener {
        void onLoginSuccess(LoginResponse list);

        void onLoginFailed(String msg);
    }

    public interface NotificationPostListener {
        void onNotificationPostSuccess(StatusMessage list);

        void onNotificationPostFailed(String msg);
    }

    public interface ServiceNameRateDownloadListener {
        void onServiceNameRateDownloadSuccess(List<ServiceNameRate> list);

        void onServiceNameRateDownloadFailed(String msg);
    }

    public interface BlogCategoryPostListener {
        void onBlogCategoryPostSuccess(StatusMessage list);

        void onBlogCategoryPostFailed(String msg);
    }

    public interface BlogCategoryDownloadListener {
        void onBlogCategoryDownloadSuccess(List<BlogCategoryNameID> list);

        void onBlogCategoryDownloadFailed(String msg);
    }

    public interface MedicicinePostListener {
        void onMedicicinePostSuccess(StatusMessage list);

        void onMedicicinePostFailed(String msg);
    }

    public interface VideoCallHistoryDownloadListenerPatient {
        void onVideoCallHistoryDownloadSuccess(List<VideoCallHistoryModel> data);

        void onVideoCallHistoryDownloadFailed(String msg);
    }

    public interface MyPrescriptionRequestDownloadListener {
        void onMyPrescriptionRequestDownloadSuccess(List<PrescriptionRequestModel> data);

        void onMyPrescriptionRequestDownloadFailed(String msg);
    }

    public interface ReviewRequestDownloadListener {
        void onReviewRequestDownloadSuccess(List<PrescriptionReviewModel> response);

        void onReviewRequestDownloadFailed(String msg);
    }

    public interface ProfileUpdateListener {
        void onProfileUpdateSuccess(StatusMessage response);

        void onProfileUpdateFailed(String msg);
    }

    public interface StatusDownloadListener {
        void onStatusDownloadSuccess(Status response);

        void onStatusDownloadFailed(String msg);
    }

    public interface appoinetmentsDownloadListener {
        void onAppointmentDownloadSuccess(List<AppointmentModelNew> status);

        void onAppointmentDownloadFailed(String msg);
    }

    public interface DoctorDocDownloadListener {
        void onDoctorDocDownloadSuccess(List<DocumentModel> status);

        void onDoctorDocDownloadFailed(String msg);
    }

    public interface UserDownloadListener {
        void onUserDownloadSuccess(List<CommonUserModel> data);

        void onUserDownloadFailed(String msg);
    }

    public interface DrServicesDownloadListener {
        void onDrServicesDownloadSuccess(List<DrOnlineServiceModel> data);

        void onDrServicesDownloadFailed(String msg);
    }

    public interface AllServiceDownloadListener {
        void onAllServiceDownloadSuccess(List<ServiceNameInfo> data);

        void onAllServiceDownloadFailed(String msg);
    }

    public interface drChamberEduSkillDownloadListener {
        void onChamberEduSkillDownloadSuccess(DrEduChInfoModel list);

        void onChamberEduSkillDownloadFailed(String msg);
    }

    public interface publicQueryPostListenerPatient {
        void onPublicQueryPostSuccess(StatusMessage data);

        void onPublicQueryPostFailed(String msg);
    }

    public interface AddAmbulanceListenerPatient {
        void onAddAreaPostSuccess(StatusMessage data);

        void onAddAmbulancePostFailed(String msg);
    }

    public interface AddAreaPostListenerPatient {
        void onAddAreaPostSuccess(StatusMessage data);

        void onAddAreaPostFailed(String msg);
    }

    public interface DepartmentAddListener {
        void onDepartmentAddSuccess(StatusMessage data);

        void onDepartmentAddFailed(String msg);
    }

    public interface publicQueryDownloadListenerPatient {
        void onPublicQueryDownloadSuccess(List<QueryModel> data);

        void onPublicQueryDownloadFailed(String msg);
    }

    public interface DeptDownloadListener {
        void onDepartmentDownloadSuccess(List<DeptModel> list);

        void onDepartmentDownloadFailed(String msg);
    }

    public interface LatestQueryDownloadListener {
        void onLatestQueryDownloadSuccess(List<PublicLatestQueryModel> list);

        void onLatestQueryDownloadFailed(String msg);
    }

    public interface ChatQueryDownloadListener {
        void onChatQueryDownloadSuccess(List<ChatModel> list);

        void onChatQueryDownloadFailed(String msg);
    }

    public interface DownloadMedicinesListInfoListener {
        void onDownloadMedicinesListInfoSuccess(List<MedicineModel> status);

        void onDownloadMedicinesListFailed(String msg);
    }

    public interface DownloadDistrictListInfoListener {
        void onDownloadDistrictListInfoSuccess(List<DistrictModel> status);

        void onDownloadDistrictListFailed(String msg);
    }

    public interface DownloadAmbulanceListInfoListener {
        void onDownloadAmbulanceListInfoSuccess(List<AmbulanceModel> status);

        void onDownloadAmbulanceListFailed(String msg);
    }

}
