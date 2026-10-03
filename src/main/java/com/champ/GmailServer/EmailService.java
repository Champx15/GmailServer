package com.champ.GmailServer;

import com.google.api.client.auth.oauth2.Credential;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void sendConfirmationEmail(String to, String playerName, String registrationId, String category, String proficiency  ) throws Exception {

        String htmlContent = """
        <!DOCTYPE html>
        <html lang="en">
        <head>
          <meta charset="UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <title>JPL Registration Confirmed</title>
        </head>

        <body style="margin:0; padding:0; background-color:#f4f5f7; font-family:Arial, Helvetica, sans-serif; color:#171717;">

          <table width="100%%" cellpadding="0" cellspacing="0" border="0" style="background-color:#f4f5f7; padding:40px 16px;">
            <tr>
              <td align="center">

                <table width="100%%" cellpadding="0" cellspacing="0" border="0"
                  style="max-width:620px; background:#ffffff; border-radius:16px; overflow:hidden;">

                  <!-- Header -->
                  <tr>
                    <td style="background:#111111; padding:32px 36px;">
                      <table width="100%%" cellpadding="0" cellspacing="0" border="0">
                        <tr>
                          <td>
                            <div style="font-size:13px; letter-spacing:2px; color:#bdbdbd; font-weight:bold;">
                              JPL
                            </div>

                            <div style="font-size:28px; line-height:34px; color:#ffffff; font-weight:700; margin-top:8px;">
                              Registration Confirmed
                            </div>
                          </td>

                          <td align="right" valign="middle">
                            <div style="font-size:34px; line-height:1;">
                              🏏
                            </div>
                          </td>
                        </tr>
                      </table>
                    </td>
                  </tr>

                  <!-- Content -->
                  <tr>
                    <td style="padding:36px;">

                      <div style="font-size:16px; line-height:26px;">
                        Hi <strong>%s</strong>,
                      </div>

                      <div style="font-size:15px; line-height:25px; color:#555555; margin-top:12px;">
                        Your registration for <strong>JPL</strong> has been successfully completed.
                        We have received your payment and your registration is now confirmed.
                      </div>

                      <!-- Registration ID -->
                      <table width="100%%" cellpadding="0" cellspacing="0" border="0"
                        style="margin-top:28px; background:#f7f7f7; border:1px solid #e6e6e6; border-radius:12px;">
                        <tr>
                          <td align="center" style="padding:24px 16px;">
                            <div style="font-size:11px; letter-spacing:1.5px; color:#888888; font-weight:bold;">
                              REGISTRATION ID
                            </div>

                            <div style="font-size:28px; line-height:36px; font-weight:700; letter-spacing:1px; margin-top:8px; color:#111111;">
                              %s
                            </div>

                            <div style="font-size:12px; color:#888888; margin-top:7px;">
                              Please keep this ID for future reference.
                            </div>
                          </td>
                        </tr>
                      </table>

                      <!-- Details -->
                      <div style="font-size:13px; letter-spacing:1px; color:#888888; font-weight:bold; margin-top:32px; margin-bottom:12px;">
                        REGISTRATION DETAILS
                      </div>

                      <table width="100%%" cellpadding="0" cellspacing="0" border="0"
                        style="border-top:1px solid #eeeeee;">

                        <tr>
                          <td style="padding:13px 0; border-bottom:1px solid #eeeeee; color:#777777; font-size:14px;">
                            Player Name
                          </td>
                          <td align="right" style="padding:13px 0; border-bottom:1px solid #eeeeee; font-size:14px; font-weight:600;">
                            %s
                          </td>
                        </tr>

                        <tr>
                          <td style="padding:13px 0; border-bottom:1px solid #eeeeee; color:#777777; font-size:14px;">
                            Category
                          </td>
                          <td align="right" style="padding:13px 0; border-bottom:1px solid #eeeeee; font-size:14px; font-weight:600;">
                            %s
                          </td>
                        </tr>

                        <tr>
                          <td style="padding:13px 0; border-bottom:1px solid #eeeeee; color:#777777; font-size:14px;">
                            Proficiency
                          </td>
                          <td align="right" style="padding:13px 0; border-bottom:1px solid #eeeeee; font-size:14px; font-weight:600;">
                            %s
                          </td>
                        </tr>

                        <tr>
                          <td style="padding:13px 0; color:#777777; font-size:14px;">
                            Payment
                          </td>
                          <td align="right" style="padding:13px 0; font-size:14px; font-weight:700; color:#16803c;">
                            ✓ PAID
                          </td>
                        </tr>

                      </table>

                      <!-- Message -->
                      <table width="100%%" cellpadding="0" cellspacing="0" border="0"
                        style="margin-top:30px; background:#fafafa; border-radius:10px;">
                        <tr>
                          <td style="padding:18px 20px; font-size:14px; line-height:23px; color:#555555;">
                            Your registration details have been recorded successfully.
                            Please keep this email and your Registration ID for your records.
                          </td>
                        </tr>
                      </table>

                      <div style="font-size:15px; line-height:25px; color:#555555; margin-top:28px;">
                        We look forward to seeing you on the field. 🏏
                      </div>

                      <div style="font-size:15px; line-height:24px; margin-top:24px;">
                        Best regards,<br>
                        <strong>JPL Team</strong>
                      </div>

                    </td>
                  </tr>

                  <!-- Footer -->
                  <tr>
                    <td style="background:#f8f8f8; padding:22px 36px; border-top:1px solid #eeeeee;">

                      <div style="font-size:12px; line-height:19px; color:#999999; text-align:center;">
                        This is an automated confirmation email. Please do not reply directly to this message.
                      </div>

                      <div style="font-size:12px; color:#b0b0b0; text-align:center; margin-top:7px;">
                        © JPL
                      </div>

                    </td>
                  </tr>

                </table>

              </td>
            </tr>
          </table>

        </body>
        </html>
        """.formatted(
                playerName,
                registrationId,
                playerName,
                category,
                proficiency
        );


        String plainText =
                "JPL — Registration Confirmed\n\n" +
                        "Hi " + playerName + ",\n\n" +
                        "Your registration for JPL has been successfully completed. " +
                        "We have received your payment and your registration is now confirmed.\n\n" +
                        "REGISTRATION ID\n" +
                        registrationId + "\n\n" +
                        "Please keep this ID for future reference.\n\n" +
                        "REGISTRATION DETAILS\n\n" +
                        "Player Name: " + playerName + "\n" +
                        "Category: " + category + "\n" +
                        "Proficiency: " + proficiency + "\n" +
                        "Payment: PAID\n\n" +
                        "Your registration details have been recorded successfully. " +
                        "Please keep this email and your Registration ID for your records.\n\n" +
                        "We look forward to seeing you on the field. 🏏\n\n" +
                        "Best regards,\n" +
                        "JPL Team\n\n" +
                        "---\n" +
                        "This is an automated confirmation email. Please do not reply directly to this message.\n" +
                        "© JPL";



        // 2️⃣ Authorize Gmail (headless mode if on Render)
        Credential credential = OAuthService.authorize();
        String accessToken = credential.getAccessToken();

        // 3️⃣ Create the HTML email using GmailService
        MimeMessage email = GmailService.createEmailHtml(to, "me", "Verify your UniBazaar account", htmlContent, plainText);

        // 4️⃣ Send email via Gmail API
        GmailService.sendEmail(accessToken, to, "me", "Verify your UniBazaar account", htmlContent);

    }
}
