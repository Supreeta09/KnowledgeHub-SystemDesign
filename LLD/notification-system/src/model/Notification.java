package model;

public class Notification {
    private final String notificationId;
    private final String clientId;
    private final String subscriberId;
    private final String message;
    private final Severity severity;
    private NotificationStatus status;
    private final String templateId;

    public Notification(String notificationId, String clientId, String subscriberId, String message, Severity severity, String templateId) {
        this.notificationId = notificationId;
        this.clientId = clientId;
        this.subscriberId = subscriberId;
        this.message = message;
        this.severity = severity;
        this.templateId = templateId;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public String getMessage() {
        return message;
    }

    public Severity getSeverity() {
        return severity;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }
}
