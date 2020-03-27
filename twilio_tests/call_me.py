from twilio.rest import Client
import os

# Your Account SID and Auth Token from twilio.com/console
# You can use this to make a call with a simple audio message.
account_sid = os.environ["TWILIO_SID"]
auth_token  = os.environ["TWILIO_AUTH_TOKEN"]
destination_phone = os.environ["DESTINATION_PHONE"] 
twilio_phone = os.environ["TWILIO_PHONE"]

client = Client(account_sid, auth_token)

# with open("voice.xml") as f:
#     message

url='http://demo.twilio.com/docs/voice.xml'
# I store this in pastebin to have it accesible online.  It works (Twiml)
# The pastebin will expire in 1 week
url="https://pastebin.com/raw/ShwZKPu8"

call = client.calls.create(
                        url=url,
                        to=destination_phone,
                        from_=twilio_phone
)
print(call)
